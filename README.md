# KTH-DD2480-Decide-Lab-1
## Launch Interceptor Program
This repository contains the code for the first lab in the course DD2480 at KTH. 

The program is a launch interceptor program (LIC) that determines if a interceptor should be launched based upon input radar tracking information. More info about how the launch interceptor program works can be found here: [Launch Interceptor Program - Requirements Specification](./Launch%20Interceptor%20Program%20-%20Requirements%20Specification.pdf)

The main mechanism of the LIC is the `DECIDE()`-function. The function will output a launch decision, `"YES"` or `"NO"`, based on the input data.

### How to use
Decide takes one argument, `InputData` object, and it outputs its decision to the standard output Either a `"YES"` or `"NO"`.
Thus, the user must create the `InputDate` object by providing the input date to its constructor and then call `DECIDE()` with the object as an argument.

## Statement of contributions
The main procedure for implementing the launch interceptor program was to mainly use test driven programming by first implementing black-box tests and then developing. That is, for every feature that needed to be implemented, an issue was created and assigned to two group members. One for creating the tests, another for writing the solution.

More over, every merge into main needs to have an approved review. A set of rules was set in the repository to prevent pushes directly into main and merges when no approved review existed. Squash and merge was used for every pull-request to prevent unnecessary commits in the main branch. As a result, commits such as "Fixed typo" or "Added comment" is not visible and will minimize showing irrelevant changes in the main branch. The information is however not lost, as it is still visible under the given pull-request.
### Contributions of each member
* **Adam Jonsson**: Made the tests for LIC 12-14 ([PR][PR-LIC-12-14]) and the top-level tests for the entire DECIDE program ([PR][PR-DECIDE]). Made the solution for the LIC 3-5 ([PR][PR-LIC-3-5]) and added helper function that checks the angle between three points ([PR][PR-Helper-Angle]). Also reviewed multiple PR:s and fix some minor bugs. In total wrote about 1000 lines of code.
* **Hovig Manjikian**: Made the tests for LIC 3-5 ([PR][PR-LIC-3-5]) functions, and for the PUM class ([PR][PR-PUM-class]). Made the solution for LIC 6-8 ([PR][PR-LIC-6-8]), and for the Decide function ([PR][PR-DECIDE]). Reviewed the LunchInterceptorProgram class. Contributed to the documentation. In total wrote about 1200 lines of code, made about 25 commit of which 3 are visible (the rest got squashed). 
* **Isak Vilhelmsson**: Made the tests for LIC 6-8 ([PR][PR-LIC-6-8]). Made the solution for LIC 0-2 ([PR][PR-LIC-0-2]). Implemented the PUM class ([PR][PR-PUM-class]). Reviewed these PRs: ([PR][PR-LIC-12-14]), ([PR][PR-Helper-Angle]), ([PR][PR-LIC-3-5]), ([PR][PR-Helper-Circle]), ([PR][PR-DECIDE]). Added about 350 lines of code to the project.
* **Lara Rostami**: Created tests for condition 0-2 in `LaunchInterceptorProgram.java` ([PR][PR-LIC-0-2]), created tests for `FUV.java` ([PR][PR-FUV-class]), implemented condition 12-14 in `LaunchInterceptorProgram.java` ([PR][PR-LIC-12-14]), wrote documentation in `README.md` ([PR][PR-Documentation]), reviewed PR:s, created issues. Added about 500 lines of code.
* **Tony Le**: Wrote the tests and implementation for LIC 9-11 in `LaunchInterceptorProgram.java` ([PR][PR-LIC-9-11]), and the implementation for the `FUV.java` class ([PR][PR-FUV-class]). Added roughly 350 lines of code total to the project.

## Naming conventions
* All issues have labels, which should mark how the issue is related to the project. An issue also have an id in the form `#xx`
* All branches are lexigraphically linked to issues by having names such as `issue/xx-add-feature`
* A PR adds an automatic link between the issue and the PR by having a commit message in the form `Fixes #xx`

## Examination

### "Remarkable" achievement

#### Test-driven development
As was mentioned above, our group decided on doing test-driven development. The implementation of a feature was made in three steps:

1. One author creates the tests that they expect to pass.
2. Another author creates the feature trying to pass the tests.
3. And a third author did the reviewing of the code.

In this approach we were choosing the team members that are best in the given area to write the tests, which will insure a higher quality of code.
Additionally, with this approach we get advantages like ensuring that:

1. There are valid tests that the feature must pass before the feature is being created
2. The project members know more about several parts of the code, rather than only knowing the code they wrote themselves

We think this is of `remarkable`-quality, since we ensured that the system would be working well while integrating the features, as well as allow project members to be more familiar with more parts of the code infrastructure. By doing this, we reduce the risk of having something going wrong throughout the development process. 

#### Consistent github workflow
We have
* Continuously linked commits to issues
* Kept a naming convention in our branches that link to issues of the form `issue/xx-add-feature`
* Prevented any direct push to main
* Kept a squash-and-merge merging strategy
* Required at least 1 code review for each PR

We also believe this is of `remarkable`-quality, since this makes it much easier for the group to view what other people are doing in the project as well as prevent erroneus code to be pushed te be pushed to the `main`-branch, which could be disastrous in a deployed system.

### Note to examinator
One of us accidentally made a normal merge to a pull request and not a squash and merge, as we had agreed to in the group. We therefore ask the examinor to not consider these commits in the `issue/12-lic-9-11`-branch as examinatory, as it is very difficult to revert the git history. We chose to keep it as it is as to not confuse ourselves or the examinator.

[PR-LIC-12-14]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/14
[PR-LIC-9-11]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/26
[PR-LIC-6-8]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/23
[PR-LIC-3-5]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/22
[PR-LIC-0-2]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/15
[PR-DECIDE]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/33
[PR-Helper-Angle]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/20
[PR-Helper-Circle]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/24
[PR-FUV-class]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/38
[PR-PUM-class]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/32
[PR-Documentation]: https://github.com/AdamJonsson/KTH-DD2480-Decide-Lab-1/pull/35
