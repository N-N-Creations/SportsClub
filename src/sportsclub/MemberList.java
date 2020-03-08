
package sportsclub;

/**
 *
 * @author N&N Creations
 */
public class MemberList {
    private String id;
    private String name;
    private String phone;
    private String dob;
    private String bg;
    private String ctgry;
    
    
    
    
    public MemberList(String id,String name,String phone ,String dob,String bg,String ctgry){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.dob=dob;
        this.bg=bg;
        this.ctgry=ctgry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getCtgry() {
        return ctgry;
    }

    public void setCtgry(String ctgry) {
        this.ctgry = ctgry;
    }
    
    
    
    
}
