
package com.example.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "period_duration",
    "page",
    "search_id",
    "periods"
})
public class BlockedDeviceEvents {

    @JsonProperty("period_duration")
    private String periodDuration;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("search_id")
    private String searchId;
    @JsonProperty("periods")
    private List<Period> periods = new ArrayList<Period>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("period_duration")
    public String getPeriodDuration() {
        return periodDuration;
    }

    @JsonProperty("period_duration")
    public void setPeriodDuration(String periodDuration) {
        this.periodDuration = periodDuration;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("search_id")
    public String getSearchId() {
        return searchId;
    }

    @JsonProperty("search_id")
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @JsonProperty("periods")
    public List<Period> getPeriods() {
        return periods;
    }

    @JsonProperty("periods")
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BlockedDeviceEvents.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("periodDuration");
        sb.append('=');
        sb.append(((this.periodDuration == null)?"<null>":this.periodDuration));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("searchId");
        sb.append('=');
        sb.append(((this.searchId == null)?"<null>":this.searchId));
        sb.append(',');
        sb.append("periods");
        sb.append('=');
        sb.append(((this.periods == null)?"<null>":this.periods));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.periodDuration == null)? 0 :this.periodDuration.hashCode()));
        result = ((result* 31)+((this.periods == null)? 0 :this.periods.hashCode()));
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.searchId == null)? 0 :this.searchId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BlockedDeviceEvents) == false) {
            return false;
        }
        BlockedDeviceEvents rhs = ((BlockedDeviceEvents) other);
        return ((((((this.periodDuration == rhs.periodDuration)||((this.periodDuration!= null)&&this.periodDuration.equals(rhs.periodDuration)))&&((this.periods == rhs.periods)||((this.periods!= null)&&this.periods.equals(rhs.periods))))&&((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.searchId == rhs.searchId)||((this.searchId!= null)&&this.searchId.equals(rhs.searchId))));
    }

}
