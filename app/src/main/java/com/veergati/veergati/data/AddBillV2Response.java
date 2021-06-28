
package com.veergati.veergati.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddBillV2Response {

    @SerializedName("postResp")
    @Expose
    private List<PostResp> postResp = null;

    public List<PostResp> getPostResp() {
        return postResp;
    }

    public void setPostResp(List<PostResp> postResp) {
        this.postResp = postResp;
    }

}
