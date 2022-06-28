package com.morajlab.app.models;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Function {
    private String arguments;
    private boolean v_public;

    @XmlAttribute
    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public void setPublic(boolean v_public) {
        this.v_public = v_public;
    }

    public String getArguments() {
        return this.arguments;
    }

    public boolean getPublic() {
        return this.v_public;
    }
}