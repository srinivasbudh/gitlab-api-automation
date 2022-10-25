Feature: Verify update issues api

  @Regression
  Scenario Outline: Verify an authorized user is able to update an existing Issue on a Gitlab repository
    Given An Authorized user is accessing a Gitlab private repository
    When He Attempts to update an issue with valid details
      |title  |state_event  |milestone_id  |created_at| iid  |
      |<title>|<state_event>|<milestone_id>|<created_at>| <iid>|
    Then Issue is updated successfully
    And the issue is updated correctly
      |title  |state_event  |milestone_id  |created_at| iid  |
      |<title>|<state_event>|<milestone_id>|<created_at>| <iid>|
    And Issue with Iid <iid>, is available in the list
    Examples:
      |title            |state_event       |milestone_id  |created_at  | iid  |
      |updated Title    |                  |              |            | 2     |
      |                 |  close           |              |            | 2     |
      |                 |                  | 2842089      |            | 1     |
    @Bug
    Examples:
      |title            |state_event       |milestone_id  |created_at  | iid  |
      |                 |                  |     | 2012-10-25T17:28:33.777Z| 1 |
