import java.io.File;
import java.io.IOException;

//非RunTimeException
//編譯時Error 跳出unreported exception IOException 必須自己去api裡尋找錯誤原因訊息
class Ex2{
	public static void main(String[] args){
		File f=new File("c:/ocp/day16/sample.jpg");//新增路徑
		
		try{
			f.createNewFile();//新增資料夾
		}
		
		catch(IOException e){
			e.printStackTrace();//顯示錯誤訊息
		}
		
	}
}