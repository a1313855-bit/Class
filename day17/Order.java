class Order{
	private String name;
	private int lcd;
	private int ram;

	//建構式後面 throws Exception 表示影響此建構式
	//由於Exception跟Check有繼承關西 Check也會影響到Exception
	Order(String name,int lcd,int ram) throws Check /*throws Exception*/{//用throws 接收Exception
		if(lcd>=0 && ram>=0){
			this.name=name;
			this.lcd=lcd;
			this.ram=ram;
		}else{
			//throw 把Exception丟出去
			throw new Check("新增lcd與ram的數量",true);//自訂Exception Check
			//()裡的文字是寫在 e.printStackTrace

			/*可編譯，但因生命週期的原因throw 影響不到Order
			//導致這段程式碼雖執行但不影響
			try{
				
				//Exception e=new Exception();
				//throw e;

				throw new Exception;
			}catch{
				
			}
			*/			
		}
	}

	void show(){
		System.out.println("名:"+name+
			"\tlcd:"+lcd+
			"\tram:"+ram);			
	}

	//方法後面 throws Exception 表示影響此方法
	void setLcd(int lcd) throws Check/*throws Exception*/{//用throws 接收Check
		if(lcd>=0){
			this.lcd=lcd;
		}else{
			//throw 把Exception丟出去
			throw new Check("修改lcd");//自訂Exception Check
		}
	}

	void setRam(int ram) throws Check/*throws Exception*/{//用throws 接收Check
		if(ram>=0){
			this.ram=ram;
		}else{
			throw new Check("修改ram");//自訂Exception Check
		}
	}

}