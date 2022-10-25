Feature: Verify create issue is possible from gitlab API

  @Regression
  Scenario Outline: Verify an authorized user is able to create an Issue on a Gitlab repository
    Given An Authorized user is accessing a Gitlab private repository
    When He Attempts to create an issue with valid details
      |title  |description  |milestone_id  | iid  |
      |<title>|<description>|<milestone_id>| <iid>|
    Then Issue is created successfully
    And the issue is visible list of total Issues
    Examples:
      |title            |description       |milestone_id  |  iid  |
      |new Title        | new description  |              | 1     |
      |milestone title  |  description     |   2842089    | 2     |
  @Regression
  Scenario: Verify an Unauthorized user is not able to create an Issue on a Gitlab repository
    Given An UnAuthorized user is accessing a Gitlab private repository
    When He Attempts to create an issue with valid details
      | title | description|
      |UnAuthorized title| UnAuthorized scenario|
    Then Issue is not created successfully

  @Regression
  Scenario: Verify an authorized user is not able to create a duplicate Issue on a Gitlab repository
    Given An Authorized user is accessing a Gitlab private repository
    When He Attempts to create an issue with valid details
      | title         | description       | iid |
      |duplicate title| duplicate scenario| 0   |
    Then Issue is not created successfully
    And the issue is not visible list of total Issues

    @Bug @Regression
  Scenario: Verify a issue cant be created with a past date
      Given An Authorized user is accessing a Gitlab private repository
      When He Attempts to create an issue with old created_at date details
        |title            | created_at                    | iid|
        |old date title   |  2012-12-24T16:12:26.314Z     | 3  |
      Then Issue is not created successfully
