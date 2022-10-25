
package com.gitlab.issues.models.payload;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "assignee_id",
    "assignee_ids ",
    "confidential",
    "created_at",
    "description",
    "discussion_to_resolve",
    "due_date",
    "epic_id ",
    "epic_iid ",
    "id",
    "iid",
    "issue_type",
    "labels",
    "merge_request_to_resolve_discussions_of",
    "milestone_id",
    "title",
    "weight "
})
public class CreateIssuePayload {

    @JsonProperty("assignee_id")
    private Long assigneeId;
    @JsonProperty("assignee_ids ")
    private Long assigneeIds;
    @JsonProperty("confidential")
    private Boolean confidential;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("description")
    private String description;
    @JsonProperty("discussion_to_resolve")
    private String discussionToResolve;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("epic_id ")
    private Long epicId;
    @JsonProperty("epic_iid ")
    private Long epicIid;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("iid")
    private Long iid;
    @JsonProperty("issue_type")
    private String issueType;
    @JsonProperty("labels")
    private String labels;
    @JsonProperty("merge_request_to_resolve_discussions_of")
    private Long mergeRequestToResolveDiscussionsOf;
    @JsonProperty("milestone_id")
    private Long milestoneId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    @NotNull
    private String title;
    @JsonProperty("weight ")
    private Long weight;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("assignee_id")
    public Long getAssigneeId() {
        return assigneeId;
    }

    @JsonProperty("assignee_id")
    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    @JsonProperty("assignee_ids ")
    public Long getAssigneeIds() {
        return assigneeIds;
    }

    @JsonProperty("assignee_ids ")
    public void setAssigneeIds(Long assigneeIds) {
        this.assigneeIds = assigneeIds;
    }

    @JsonProperty("confidential")
    public Boolean getConfidential() {
        return confidential;
    }

    @JsonProperty("confidential")
    public void setConfidential(Boolean confidential) {
        this.confidential = confidential;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("discussion_to_resolve")
    public String getDiscussionToResolve() {
        return discussionToResolve;
    }

    @JsonProperty("discussion_to_resolve")
    public void setDiscussionToResolve(String discussionToResolve) {
        this.discussionToResolve = discussionToResolve;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("epic_id ")
    public Long getEpicId() {
        return epicId;
    }

    @JsonProperty("epic_id ")
    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    @JsonProperty("epic_iid ")
    public Long getEpicIid() {
        return epicIid;
    }

    @JsonProperty("epic_iid ")
    public void setEpicIid(Long epicIid) {
        this.epicIid = epicIid;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("iid")
    public Long getIid() {
        return iid;
    }

    @JsonProperty("iid")
    public void setIid(Long iid) {
        this.iid = iid;
    }

    @JsonProperty("issue_type")
    public String getIssueType() {
        return issueType;
    }

    @JsonProperty("issue_type")
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @JsonProperty("labels")
    public String getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(String labels) {
        this.labels = labels;
    }

    @JsonProperty("merge_request_to_resolve_discussions_of")
    public Long getMergeRequestToResolveDiscussionsOf() {
        return mergeRequestToResolveDiscussionsOf;
    }

    @JsonProperty("merge_request_to_resolve_discussions_of")
    public void setMergeRequestToResolveDiscussionsOf(Long mergeRequestToResolveDiscussionsOf) {
        this.mergeRequestToResolveDiscussionsOf = mergeRequestToResolveDiscussionsOf;
    }

    @JsonProperty("milestone_id")
    public Long getMilestoneId() {
        return milestoneId;
    }

    @JsonProperty("milestone_id")
    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("weight ")
    public Long getWeight() {
        return weight;
    }

    @JsonProperty("weight ")
    public void setWeight(Long weight) {
        this.weight = weight;
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
        sb.append(CreateIssuePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("assigneeId");
        sb.append('=');
        sb.append(((this.assigneeId == null)?"<null>":this.assigneeId));
        sb.append(',');
        sb.append("assigneeIds");
        sb.append('=');
        sb.append(((this.assigneeIds == null)?"<null>":this.assigneeIds));
        sb.append(',');
        sb.append("confidential");
        sb.append('=');
        sb.append(((this.confidential == null)?"<null>":this.confidential));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("discussionToResolve");
        sb.append('=');
        sb.append(((this.discussionToResolve == null)?"<null>":this.discussionToResolve));
        sb.append(',');
        sb.append("dueDate");
        sb.append('=');
        sb.append(((this.dueDate == null)?"<null>":this.dueDate));
        sb.append(',');
        sb.append("epicId");
        sb.append('=');
        sb.append(((this.epicId == null)?"<null>":this.epicId));
        sb.append(',');
        sb.append("epicIid");
        sb.append('=');
        sb.append(((this.epicIid == null)?"<null>":this.epicIid));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("iid");
        sb.append('=');
        sb.append(((this.iid == null)?"<null>":this.iid));
        sb.append(',');
        sb.append("issueType");
        sb.append('=');
        sb.append(((this.issueType == null)?"<null>":this.issueType));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("mergeRequestToResolveDiscussionsOf");
        sb.append('=');
        sb.append(((this.mergeRequestToResolveDiscussionsOf == null)?"<null>":this.mergeRequestToResolveDiscussionsOf));
        sb.append(',');
        sb.append("milestoneId");
        sb.append('=');
        sb.append(((this.milestoneId == null)?"<null>":this.milestoneId));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null)?"<null>":this.weight));
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
        result = ((result* 31)+((this.discussionToResolve == null)? 0 :this.discussionToResolve.hashCode()));
        result = ((result* 31)+((this.iid == null)? 0 :this.iid.hashCode()));
        result = ((result* 31)+((this.dueDate == null)? 0 :this.dueDate.hashCode()));
        result = ((result* 31)+((this.milestoneId == null)? 0 :this.milestoneId.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.weight == null)? 0 :this.weight.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.assigneeId == null)? 0 :this.assigneeId.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.issueType == null)? 0 :this.issueType.hashCode()));
        result = ((result* 31)+((this.createdAt == null)? 0 :this.createdAt.hashCode()));
        result = ((result* 31)+((this.epicId == null)? 0 :this.epicId.hashCode()));
        result = ((result* 31)+((this.epicIid == null)? 0 :this.epicIid.hashCode()));
        result = ((result* 31)+((this.mergeRequestToResolveDiscussionsOf == null)? 0 :this.mergeRequestToResolveDiscussionsOf.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.assigneeIds == null)? 0 :this.assigneeIds.hashCode()));
        result = ((result* 31)+((this.confidential == null)? 0 :this.confidential.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateIssuePayload) == false) {
            return false;
        }
        CreateIssuePayload rhs = ((CreateIssuePayload) other);
        return (((((((((((((((((((this.discussionToResolve == rhs.discussionToResolve)||((this.discussionToResolve!= null)&&this.discussionToResolve.equals(rhs.discussionToResolve)))&&((this.iid == rhs.iid)||((this.iid!= null)&&this.iid.equals(rhs.iid))))&&((this.dueDate == rhs.dueDate)||((this.dueDate!= null)&&this.dueDate.equals(rhs.dueDate))))&&((this.milestoneId == rhs.milestoneId)||((this.milestoneId!= null)&&this.milestoneId.equals(rhs.milestoneId))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.weight == rhs.weight)||((this.weight!= null)&&this.weight.equals(rhs.weight))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.assigneeId == rhs.assigneeId)||((this.assigneeId!= null)&&this.assigneeId.equals(rhs.assigneeId))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.issueType == rhs.issueType)||((this.issueType!= null)&&this.issueType.equals(rhs.issueType))))&&((this.createdAt == rhs.createdAt)||((this.createdAt!= null)&&this.createdAt.equals(rhs.createdAt))))&&((this.epicId == rhs.epicId)||((this.epicId!= null)&&this.epicId.equals(rhs.epicId))))&&((this.epicIid == rhs.epicIid)||((this.epicIid!= null)&&this.epicIid.equals(rhs.epicIid))))&&((this.mergeRequestToResolveDiscussionsOf == rhs.mergeRequestToResolveDiscussionsOf)||((this.mergeRequestToResolveDiscussionsOf!= null)&&this.mergeRequestToResolveDiscussionsOf.equals(rhs.mergeRequestToResolveDiscussionsOf))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.assigneeIds == rhs.assigneeIds)||((this.assigneeIds!= null)&&this.assigneeIds.equals(rhs.assigneeIds))))&&((this.confidential == rhs.confidential)||((this.confidential!= null)&&this.confidential.equals(rhs.confidential))));
    }

}
