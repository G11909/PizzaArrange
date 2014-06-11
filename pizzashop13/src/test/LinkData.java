package test;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {

	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	     
	    @Persistent
	    private String name;
	     
	    @Persistent
	    private String url;
	     
	    @Persistent
	    private String count1;
	     
	    @Persistent
	    private String count2;
	    
	    @Persistent
	    private String count3;
	     
	    @Persistent
	    private String count4;	
	    
	    @Persistent
	    private String total;
	    
	 
	    public LinkData(String title, String url,String count1, String count2, String count3, String count4, String count5) {
	        super();
	        this.name = title;
	        this.url = url;
	        this.count1 = count1;
	        this.count2 = count2;
	        this.count3 = count3;
	        this.count4 = count4;
	        this.total = count5;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public String getTitle() {
	        return name;
	    }
	 
	    public void setTitle(String title) {
	        this.name = title;
	    }
	 
	    public String getUrl() {
	        return url;
	    }
	 
	    public void setUrl(String url) {
	        this.url = url;
	    }
	 
	    public String getCount1() {
	        return count1;
	    }
	 
	    public void setCount1(String count1) {
	        this.count1 = count1;
	    }
	 
	    public String getCount2() {
	        return count2;
	    }
	 
	    public void setCount2(String count2) {
	        this.count2 = count2;
	    }	
	    
	    public String getCount3(){
	    	return count3;
	    }
	    
	    public void setCount3(String count3){
	    	this.count3 = count3;
	    }
	    
	    public String getCount4(){
	    	return count4;
	    }
	    
	    public void setCount4(String count4){
	    	this.count4 = count4;
	    }
	    
	    public String getCount5(){
	    	return total;
	    }
	    
	    public void setCount5(String count5){
	    	this.total = count5;
	    }

	
}
