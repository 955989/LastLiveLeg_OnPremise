/**
 *@author rswami
* POJO to store Sequence details to CCS service
*/

package com.aa.entities.ccsRequest;

import java.util.List;

public class SequenceByKeysRequest {

    private List<String> gets;

    private boolean includeDutyPeriods;

    private List<SequenceInfoKey> sequenceInfoKeys;

    public List<String> getGets() {
        return gets;
    }

    public void setGets(final List<String> gets) {
        this.gets = gets;
    }

    public boolean isIncludeDutyPeriods() {
        return includeDutyPeriods;
    }

    public void setIncludeDutyPeriods(final boolean includeDutyPeriods) {
        this.includeDutyPeriods = includeDutyPeriods;
    }

    public List<SequenceInfoKey> getSequenceInfoKeys() {
        return sequenceInfoKeys;
    }

    public void setSequenceInfoKeys(final List<SequenceInfoKey> sequenceInfoKeys) {
        this.sequenceInfoKeys = sequenceInfoKeys;
    }

    @Override
    public String toString() {
        return "SequenceByKeysRequest [gets=" + gets + ", includeDutyPeriods=" + includeDutyPeriods
                + ", sequenceInfoKeys=" + sequenceInfoKeys + "]";
    }

}
