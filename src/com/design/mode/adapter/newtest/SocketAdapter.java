package com.design.mode.adapter.newtest;

/**
 *
 * 现在我去德国旅游，带去的三项扁头的手机充电器。如果没有带电源适配器，我是不能充电的，因为不可能为了我一个旅客而为我更改墙上的插座，更不可能为我专门盖一座使用中国国标插座的宾馆。
 * 因为人家德国人一直这么使用，并且用的挺好，俗话说入乡随俗，我就要自己想办法来解决问题。
 * 对应到我们的代码中，也就是说，上面的Hotel类，DBSocket类，DBSocketInterface接口都是不可变的（由德国的客户提供），如果我想使用这一套API，那么只能自己写代码解决。
 * 可以认为这两个东西是我带到德国去的，目前他们还不能使用，因为接口不一样。那么我必须创建一个适配器，这个适配器必须满足以下条件：
 *
 * 1 必须符合德国标准的接口，否则的话还是没办法插到德国插座中； 
 * 2 在调用上面实现的德标接口进行充电时，提供一种机制，将这个调用转到对国标接口的调用 。
 * 
 * 这就要求： 
 * 1 适配器必须实现原有的德标的接口 
 * 	2 适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。
 * 
 * @author Computer
 *
 */
public class SocketAdapter  implements DBSocketInterface{
	 
    private GBSocketInterface gbSocket;				//组合新接口   
 
    public SocketAdapter(GBSocketInterface gbSocket) {   //在创建适配器对象时，必须传入一个新街口的实现类 
        this.gbSocket = gbSocket;  
    }
	@Override
	public void powerWithTwoRound() {		//通过适配器的实现的德标接口的方法与国标的接口连起来，实现我调用德标的充电口时实际是通过国标的接口来实现的
		 gbSocket.powerWithThreeFlat();  
	} 

}
