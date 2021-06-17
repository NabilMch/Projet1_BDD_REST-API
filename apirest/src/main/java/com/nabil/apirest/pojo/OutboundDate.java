
package com.nabil.apirest.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PartialDate",
    "Price",
    "QuoteDateTime",
    "QuoteIds"
})
@Generated("jsonschema2pojo")
public class OutboundDate {

    @JsonProperty("PartialDate")
    private String partialDate;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;
    @JsonProperty("QuoteIds")
    private List<Integer> quoteIds = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PartialDate")
    public String getPartialDate() {
        return partialDate;
    }

    @JsonProperty("PartialDate")
    public void setPartialDate(String partialDate) {
        this.partialDate = partialDate;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("QuoteDateTime")
    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    @JsonProperty("QuoteDateTime")
    public void setQuoteDateTime(String quoteDateTime) {
        this.quoteDateTime = quoteDateTime;
    }

    @JsonProperty("QuoteIds")
    public List<Integer> getQuoteIds() {
        return quoteIds;
    }

    @JsonProperty("QuoteIds")
    public void setQuoteIds(List<Integer> quoteIds) {
        this.quoteIds = quoteIds;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
