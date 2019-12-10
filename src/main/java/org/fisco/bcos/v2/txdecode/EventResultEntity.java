package org.fisco.bcos.v2.txdecode;

import org.fisco.bcos.v2.abi.datatypes.Type;

public class EventResultEntity extends ResultEntity {
    private boolean indexed;

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public EventResultEntity(String name, String type, boolean indexed, Type data) {
        super(name, type, data);

        this.setIndexed(indexed);
    }

    @Override
    public String toString() {
        return "EventResultEntity [name="
                + getName()
                + ", type="
                + getType()
                + ", data="
                + getData()
                + ", indexed="
                + indexed
                + "]";
    }
}
