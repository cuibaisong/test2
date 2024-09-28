package com.skynet.skynet_po_api.job.common;
import java.io.Serializable;

public class BaseModel implements Serializable{

    private static final long serialVersionUID = 1001943494952931101L;

    private int page;

    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
