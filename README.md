# KTH-DD2480-Decide-Lab-1
## Launch Interceptor Program
This repository contains the code for the first lab in the course DD2480 at KTH. 

The program is a launch interceptor program (LIC) that determines if a interceptor should be launched based upon input radar tracking information. More info about how the launch interceptor program works can be found here: [Launch Interceptor Program - Requirements Specification](./Launch%20Interceptor%20Program%20-%20Requirements%20Specification.pdf)

The main mechanism of the LIC is in the `DECIDE()`-function, which generates a boolean signal, `true` or  `false`, based on input data. The output of `DECIDE()` whether the LIC interceptor should launched or not.

The user inputs the data in the form given in `InputDataProvider.java`. The program `DECIDE()` then generates the signal based on this input. The `DECIDE()`-function makes calculates with the input in several steps before arriving to the result.

### How it works
The class `LaunchInterceptorProgram.java` takes input in the form of `InputData.java` and generates a PUM with `PUM.java`, which calls `LaunchInterceptorConditions.java` to create its output. Then, the FUV is created from the PUM and other input from `InputData.java`, using `FUV.java`. The boolean signal is based on the resulting FUV.

### How to use
Currently, the program do not take any external inputs. To test your own set of inputs, you can add them in the `InputDataProvider.java` and test them by calling the decide function inside a test.

### Code structure
* `FUV.java`
* `tests/FUVTest.java`

Creates the Final Unlocking Vector FUV, a boolean array that is used in the final step.

* `PUM.java`
* `tests/PUMTest.java`

Creates the Preliminary Unlocking Matrix PUM, a boolean matrix that is used in an intermediate step.

* `InputData.java`

A class for handling all the PARAMETERS and collects them in a class

* `LaunchInterceptorConditions.java`
* `tests/LaunchInterceptorConditionsTest.java`

A class that implements 14 conditions that have been calculated from the `InputData`-input.

* `LaunchInterceptorProgram.java`
* `tests/LaunchInterceptorProgramTest.java`

A class that define the `DECIDE()`-function, which will return a boolean signal based on the `InputData`-signal.


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

## Naming conventions
* All issues have labels, which should mark how the issue is related to the project. An issue also have an id in the form `#xx`
* All branches are lexigraphically linked to issues by having names such as `issue/xx-add-feature`
* A PR adds an automatic link between the issue and the PR by having a commit message in the form `Fixes #xx`

## Examination

### "Remarkable" achievement

#### Test-driven development
As was mentioned above, our group decided on doing test-driven development. The implementation of a feature was made in two steps:

1. One author creates the tests that they expect to pass
2. Another author creates the feature trying to pass the tests

By doing this way, we ensure that 

1. There are valid tests that the feature must pass before the feature is being created
2. The project members know more about several parts of the code, rather than only knowing the code they wrote themselves

We think this is of `remarkable`-quality, since we ensured that the system would be working well while integrating the features, as well as allow project members to be more familiar with more parts of the code infrastructure. By doing this, we reduce the risk of having something going wrong throughout the development process. 


### Note to examinator
One of us accidentally made a normal merge to a pull request and not a squash and merge, as we had agreed to in the group. We therefore ask the examinor to not consider these commits in the `main`-branch as examinatory, as it is very difficult to revert the git history. We chose to keep it as it is as to not confuse ourselves or the examinator.