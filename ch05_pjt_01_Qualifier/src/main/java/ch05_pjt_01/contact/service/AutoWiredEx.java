package ch05_pjt_01.contact.service;

public class AutoWiredEx {

	public AutoWiredEx(
	           FirstBean fBean, 
	             SecondBean sBean) 
	    {
	        System.out.println("firstBean: " + fBean);
	        System.out.println("secondBean: " + sBean);
	    }
	    
	   
	    public void autowiredMethod(ThirdBean tBean, 
	          FourthBean fBean) 
	    {
	        System.out.println("thirdBean: " + tBean);
	        System.out.println("fourthBean: " + fBean);
	    }
}
