Feature: Verify view issues api

  @Regression
  Scenario Outline: Verify users are able to view issues of different IssueTypes
    Given An <UserType> user is accessing a Gitlab <RepositoryType> repository
    When He Attempts to view all the issues
    Then All the list of issues <status> Visible
    Examples:
    |UserType    |RepositoryType|status|
    |Authorized  |public        |are    |
    |Authorized  |private       |are    |
    |UnAuthorized|public        |are    |
    |UnAuthorized|private       |are not|

  @Regression @Bug
  Scenario: Verify a user can view issues with milestones using view Issues ApI
    Given An Authorized user is accessing a Gitlab private repository
    When Attempts to view issue with Milestone 2842089
    Then All the list of issues are Visible
    And Issue with Iid 2, is available in the list
