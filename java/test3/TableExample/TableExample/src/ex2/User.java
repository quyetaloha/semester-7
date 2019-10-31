
package ex2;

import java.io.Serializable;



public class User implements Serializable{
    private String name,group;
    private String level;
    private boolean enabled;

    public User(String name, String group, String level, boolean enabled) {
        this.name = name;
        this.group = group;
        this.level = level;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    Object[] toObject(){
        return new Object[]{
           name,group,level,enabled  
        };
    }
}
