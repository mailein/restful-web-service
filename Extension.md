# Extend the current code base
## Current code base
- A service receives POST requests of type Warning or Info
- The service sends a POST request to Slack for each Warning

## Requirements
- Extend from only Slack to the following notification target systems
  - E-Mail
  - SMS
  - Discord
  - Microsoft Teams
  - ...

## Assumptions
- There exists a User service
- Each target system has a subscribing users table in the database

## Reactive Solution
- Change the controllers, services, repositories to receive and send requests reactively
- Create new notification target systems with HTTP client: `@RegisterRestClient`
- Create a `findSubscribers(targetSystem)` method in the User service
- Upon receiving a Warning
  - Create a `Multi` of all notification target systems
  - [flatMap](https://smallrye.io/smallrye-mutiny/latest/guides/rx/) the `Multi`, so that the following operations are run for each target system
  - For all subscribing users of this target system: `findSubscribers(targetSystem)`
  - Send a POST request and returns immediately: `sendWarning(message)`

## Testing
- Add unit tests for different users with different notification target systems
- Set up users and run integrated tests

## Reference
- https://smallrye.io/smallrye-mutiny/latest/guides/rx/