/**
 * @author ugoudar
 * Stores LLL service request
 */
package com.aa.entities;

public class SequenceDetailsEntity {

    private String fa1ID;

    private String position;

    private String sequenceNum;

    private String seqOrigDate;

    private String fa2ID;

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    public String getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(final String sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getFa1ID() {
        return fa1ID;
    }

    public void setFa1ID(final String fa1id) {
        fa1ID = fa1id;
    }

    public String getFa2ID() {
        return fa2ID;
    }

    public void setFa2ID(final String fa2id) {
        fa2ID = fa2id;
    }

    public String getSeqOrigDate() {
        return seqOrigDate;
    }

    public void setSeqOrigDate(final String seqOrigDate) {
        this.seqOrigDate = seqOrigDate;
    }

    @Override
    public String toString() {
        return "SequenceDetails [sequenceNum=" + sequenceNum + ", fa1ID=" + fa1ID + ", fa2ID=" + fa2ID
                + ", seqOrigDate=" + seqOrigDate + ", position=" + position + "]";
    }

}
