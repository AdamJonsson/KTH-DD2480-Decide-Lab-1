# KTH-DD2480-Decide-Lab-1
## Launch Interceptor Program
This repository contains the code for the first lab in the course DD2480 at KTH. The program is a launch interceptor program that determines if a interceptor should be launched based upon input radar tracking information. More info about how the launch interceptor program works can be found here: [Launch Interceptor Program - Requirements Specification](./Launch%20Interceptor%20Program%20-%20Requirements%20Specification.pdf)

### How to use
Currently, the program do not take any external inputs. To test your own set of inputs, you can add them in the InputDataProvider.java and test them by calling the decide function inside a test.

## Statement of contributions
The main procedure for implementing the launch interceptor program was to mainly use the Black-box testing method. That is, for every feature that needed to be implemented, an issue was created and assigned to two group members. One of the two group members created tests for the given feature first, then the other group member wrote the code for the feature. The benefits of using this method was that at least two members needed to understand the problem, thus minimizing the risk of misconception about the problem.

More over, every merge into main needs to have an approved review. A set of rules was set in the repository to prevent pushes directly into main and merges when no approved review existed. Squash and merge was used for every pull-request to prevent unnecessary commits in the main branch. As a result, commits such as "Fixed typo" or "Added comment" is not visible and will minimize showing irrelevant changes in the main branch. The information is however not lost, as it is still visible under the given pull-request.

## "Remarkable" achievement
As was mentioned above, our group decided on doing test-driven development. The implementation of a feature was made in two steps:

1. One author creates the tests that they expect to pass
2. Another author creates the feature trying to pass the tests

By doing this way, we ensure that 

1. There are valid tests that the feature must pass before the feature is being created
2. The project members know more about several parts of the code, rather than only knowing the code they wrote themselves

We think this is of `remarkable`-quality, since we ensured that the system would be working well while integrating the features, as well as allow project members to be more familiar with more parts of the code infrastructure. By doing this, we reduce the risk of having something going wrong throughout the development process.


### Note to examinator
One of us accidentally made a normal merge to a pull request and not a squash and merge, as we had agreed to in the group. We therefore ask the examinor to not consider these commits in the `main`-branch as examinatory, as it is very difficult to revert the git history. We chose to keep it as it is as to not confuse ourselves or the examinator.