class Order
{
	//設計-購物系統
	//(一)收集、分析資料->資料庫
	//產品 品名1.尺->29元 2.筆->30元
	//(二)資料表->Order
	//->欄位
	/*
	name	ruler 	 pen 	 sum
	String   int     int     int
	*/
	//(三)功能需求->新增-->constructors
	/*
	1.輸入姓名、尺、筆->自動加總金額
	2.尺、筆數量>=0
	3.滿2000打95折
	4.輸出"xxx你的訂單細目為
	  尺:
	  筆:
	  總金額: 元
	 */

	//field
	String name;
	int ruler;
	int pen;
	int sum;

	//constructors-->新增階段步驟
	//可多個稱作Overload->多載化(多種狀況)--->使用時為單選
	Order(String name,int ruler,int pen)
	{
		if(ruler>=0 && pen>=0)
		{
			this.name=name;
			this.ruler=ruler;
			this.pen=pen;
			//this.sum=this.ruler*29+this.pen*30;
			sum=ruler*29+pen*30;
			if(sum>=2000) sum=(int)(sum*0.95);//注意左右datatype
		}

	}

	Order(int ruler,int pen)
	{
		if(ruler>=0 && pen>=0)
		{
			this.ruler=ruler;
			this.pen=pen;
			//this.sum=this.ruler*29+this.pen*30;
			sum=ruler*29+pen*30;
			if(sum>=2000) sum=(int)(sum*0.95);//注意左右datatype
		}

	}

	//methods

	void show()
	{
		System.out.println(name+"這是你的訂單細目:"+
		"\n尺:"+ruler+
		"\n筆:"+pen+
		"\n總金額:"+sum+"元");
	}
}