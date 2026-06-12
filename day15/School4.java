interface School4 extends School5,School6{
//School4是抽象 School5,School6也是抽象
//因為super和sub一樣是抽象->extends(繼承) 沒有override x->implements
	void show4();
}