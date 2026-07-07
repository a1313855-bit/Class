//==========extends RuntimeException==========//

/*
功能:建立一個自訂例外(Custom Exception)
補充:
Java有提供很多例外:
NullPointerException
IOException
ArithmeticException
NumberFormatException
但有時候系統需要表達自己的錯誤。
例如：
玩家不存在
商品不存在
庫存不足
餘額不足
會員不存在
Java 不知道你的專案有哪些錯誤，所以需要自己建立。
*/

class MemberNotFoundException extends RuntimeException{
	public MemberNotFoundException(String message){
		/*
		super(message)
		功能:把錯誤訊息交給父類別(RuntimeException)
		執行過程:
		1.throw new MemberNotFoundException(message);
		2.super(message)呼叫RuntimeException(message)
		3.RuntimeException會把訊息存起來，之後呼叫.getMessage()->取得訊息
		*/
		super(message);
	}
}
/*
Q:為什麼繼承RuntimeException?
A:我的例外是一種 RuntimeException。
Object
   ↑
Throwable
   ↑
Exception
   ↑
RuntimeException
   ↑
MemberNotFoundException
他擁有RuntimeException的所有功能
*/

public class ExceptionApiDemo{
	public static void main(String[] args){
		/*
		try
		功能:監控可能發生例外的程式
		->可以理解成「我知道這段程式有可能出錯。」
		執行過程:
		1.沒有錯誤->執行完成
		2.跳到catch
		*/
		try{
			login("allen","wrong-password");
		/*
		catch
		功能:接住指定的Exception
		執行過程:
		當 throw Exception發生時，JVM會往外找 catch (Exception)
		找到後就進來。
		*/
		}catch(MemberNotFoundException e){
			/*
			getMessage()
			方法:String getMessage()
			功能:取得Exception的錯誤訊息
			*/
			System.out.println("登入失敗:"+e.getMessage());
		}
	}

	static void login(String username,String password){
		/*
		String API
		方法:equals(Object obj)
		功能:比較字串內容是否相同
		補充:
		Q:為什麼不password.equals("1234")?
		A:如果password==mull -> NullPointerException
		->!"1234".equals(password) -> password==null -> false
		*/
		if(!"1234".equals(password)){//->如果密碼不是1234執行throw
			/*
			功能:主動丟出一個例外
			->這裡發生錯誤，停止目前方法交給外面處理
			補充:throw後面只能接Throwable(Exception或Error)
			*/
			throw new MemberNotFoundException("帳號或密碼錯誤");
		}
		System.out.println("登入成功");
	}
}