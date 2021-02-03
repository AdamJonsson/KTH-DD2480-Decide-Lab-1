# KTH-DD2480-Decide-Lab-1
## Launch Interceptor Program
This repository contains the code for the first lab in the course DD2480 at KTH. 

The program is a launch interceptor program (LIC) that determines if a interceptor should be launched based upon input radar tracking information. More info about how the launch interceptor program works can be found here: [Launch Interceptor Program - Requirements Specification](./Launch%20Interceptor%20Program%20-%20Requirements%20Specification.pdf)

The main mechanism of the LIC is the `DECIDE()`-function. The function will output a launch decision, `"YES"` or `"NO"`, based on the input data.


### How to use
Decide takes one argument, `InputData` object, and it outputs its decision to the standard output Either a `"YES"` or `"NO"`.
Thus, the user must create the `InputDate` object by providing the input date to its constructor and then call `DECIDE()` with the object as an argument.

### Data description

#### INPUT
* `NUMPOINTS` An integer, describing the number of planar data points.
* `POINTS` Two double vectors, which together represent the coordinates of data points.
* `PARAMETERS` A class/struct holding various parameters required for calculating the LIC.
* `LCM` An integer matrix, representing the Logical Connector Matrix. It is used to calculate the `PUM`.
* `PUV` A boolean vector, representing the Preliminary Unlocking Vector. It is used to calculate `PUM`.

#### OUTPUT
* `LAUNCH` Final launch / no launch decision encoded as ”YES”, ”NO” on the standard output. In addition, the following intermediate results are computed.
* `CMV` Conditions Met Vector.
* `PUM` Preliminary Unlocking Matrix.
* `FUV` Final Unlocking Vector.

## Statement of contributions
The main procedure for implementing the launch interceptor program was to mainly use the Black-box testing method. That is, for every feature that needed to be implemented, an issue was created and assigned to two group members. One of the two group members created tests for the given feature first, then the other group member wrote the code for the feature. The benefits of using this method was that at least two members needed to understand the problem, thus minimizing the risk of misconception about the problem.

More over, every merge into main needs to have an approved review. A set of rules was set in the repository to prevent pushes directly into main and merges when no approved review existed. Squash and merge was used for every pull-request to prevent unnecessary commits in the main branch. As a result, commits such as "Fixed typo" or "Added comment" is not visible and will minimize showing irrelevant changes in the main branch. The information is however not lost, as it is still visible under the given pull-request.

## Examination

### "Remarkable" achievement
All the commits (except the first 7 commits, which were for testing purposes) are linked to an issue describing a feature, a bug, or a documentation.
Our approach was merge and squash, so that for each issue there will be a single commit on the main branch. however, one of the team members accidentally happened to do a merge with no squash on one of the pull requests, (kindly check the note at the end).

Additionally, as was mentioned above, our group decided on doing test-driven development. The implementation of a feature was made in two steps:

1. One author creates the tests that they expect to pass.
2. Another author creates the feature trying to pass the tests.
3. And a third author did the reviewing of the code.

In this approach we were choosing the team members that are best in the given area to write the tests, which will insure a higher quality of code.
Additionally, with this approach we get advantages like ensuring that:

1. There are valid tests that the feature must pass before the feature is being created
2. The project members know more about several parts of the code, rather than only knowing the code they wrote themselves

We think this is of `remarkable`-quality, since we ensured that the system would be working well while integrating the features, as well as allow project members to be more familiar with more parts of the code infrastructure. By doing this, we reduce the risk of having something going wrong throughout the development process.


### Note to examinator
One of us accidentally made a normal merge to a pull request and not a squash and merge, as we had agreed to in the group. We therefore ask the examinor to not consider these commits in the `issue/12-lic-9-11`-branch as examinatory, as it is very difficult to revert the git history. We chose to keep it as it is as to not confuse ourselves or the examinator.