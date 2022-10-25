Feature: Verify user can remove or delete the existing issue

  @Regression
  Scenario Outline: Verify user is able to delete the existing issue
    Given An <userType> user is accessing a Gitlab <repositoryType> repository
    When He Attempts to delete an issue with <iid> details
    Then Issue <status> deleted successfully
    And Issue with Iid <iid>, <statusDelete> available in the list
    Examples:
    | userType     | repositoryType  |  iid  | status | statusDelete|
    | Authorized   | private         |  1    | is     | is not      |
    | UnAuthorized | private         |  2    | is not | is          |
    | Authorized   | private         |  2    | is     | is not      |
    | Authorized   | private         |  3    | is     | is not      |
    | Authorized   | private         |  3    | is not | is not      |
    | UnAuthorized | public          |  5    | is not | is          |
