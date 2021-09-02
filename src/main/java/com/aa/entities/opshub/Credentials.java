
/**
 *@author sivan
 *POJO to store credentials details from OpsHub Service
 */

package com.aa.entities.opshub;

public class Credentials {

    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Credentials [alias=" + alias + "]";
    }

}
