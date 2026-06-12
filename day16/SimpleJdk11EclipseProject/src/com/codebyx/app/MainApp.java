package com.codebyx.app;

import java.util.Scanner;

import com.codebyx.dao.MemberDao;
import com.codebyx.dao.impl.MemberDaoMemoryImpl;
import com.codebyx.model.Member;
import com.codebyx.service.MemberService;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDaoMemoryImpl();
        MemberService memberService = new MemberService(memberDao);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("請選擇功能：");

            try {
                switch (choice) {
                    case 1:
                        createMember(memberService);
                        break;
                    case 2:
                        listMembers(memberService);
                        break;
                    case 3:
                        findMember(memberService);
                        break;
                    case 4:
                        updateMember(memberService);
                        break;
                    case 5:
                        deleteMember(memberService);
                        break;
                    case 0:
                        running = false;
                        System.out.println("系統結束，謝謝使用。");
                        break;
                    default:
                        System.out.println("無效選項，請重新輸入。\n");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("錯誤：" + ex.getMessage() + "\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println(" JDK 11 Eclipse 會員管理系統");
        System.out.println("==============================");
        System.out.println("1. 新增會員");
        System.out.println("2. 查詢全部會員");
        System.out.println("3. 依 ID 查詢會員");
        System.out.println("4. 修改會員");
        System.out.println("5. 刪除會員");
        System.out.println("0. 離開");
    }

    private static void createMember(MemberService memberService) {
        String name = readLine("姓名：");
        String email = readLine("Email：");
        String phone = readLine("電話：");

        Member member = memberService.createMember(name, email, phone);
        System.out.println("新增成功：" + member + "\n");
    }

    private static void listMembers(MemberService memberService) {
        System.out.println("會員列表：");
        memberService.getAllMembers().forEach(System.out::println);
        System.out.println();
    }

    private static void findMember(MemberService memberService) {
        int id = readInt("請輸入會員 ID：");
        memberService.getMemberById(id)
                .ifPresentOrElse(
                        member -> System.out.println("查詢結果：" + member + "\n"),
                        () -> System.out.println("查無此會員。\n"));
    }

    private static void updateMember(MemberService memberService) {
        int id = readInt("請輸入要修改的會員 ID：");
        String name = readLine("新姓名：");
        String email = readLine("新 Email：");
        String phone = readLine("新電話：");

        boolean updated = memberService.updateMember(id, name, email, phone);
        System.out.println(updated ? "修改成功。\n" : "查無此會員，修改失敗。\n");
    }

    private static void deleteMember(MemberService memberService) {
        int id = readInt("請輸入要刪除的會員 ID：");
        boolean deleted = memberService.deleteMember(id);
        System.out.println(deleted ? "刪除成功。\n" : "查無此會員，刪除失敗。\n");
    }

    private static String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("請輸入整數。");
            }
        }
    }
}
