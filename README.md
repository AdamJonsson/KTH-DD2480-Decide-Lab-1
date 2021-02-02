# KTH-DD2480-Decide-Lab-1
## Launch Interceptor Program
This repository contains the code for the first lab in the course DD2480 at KTH. The program is a launch interceptor program that determines if a interceptor should be launched based upon input radar tracking information. More info about how the launch interceptor program works can be found here: [Launch Interceptor Program - Requirements Specification](./Launch%20Interceptor%20Program%20-%20Requirements%20Specification.pdf)

### How to use
Currently, the program do not take any external inputs. To test your own set of inputs, you can add them in the InputDataProvider.java and test them by calling the decide function inside a test.

## Statement of contributions
The main procedure for implementing the launch interceptor program was to mainly use the Black-box testing method. That is, for every feature that needed to be implemented, an issue was created and assigned to two group members. One of the two group members created tests for the given feature first, then the other group member wrote the code for the feature. The benefits of using this method was that at least two members needed to understand the problem, thus minimizing the risk of misconception about the problem.

More over, every merge into main needs to have an approved review. A set of rules was set in the repository to prevent pushes directly into main and merges when no approved review existed. Squash and merge was used for every pull-request to prevent unnecessary commits in the main branch. As a result, commits such as "Fixed typo" or "Added comment" is not visible and will minimize showing irrelevant changes in the main branch. The information is however not lost, as it is still visible under the given pull-request.