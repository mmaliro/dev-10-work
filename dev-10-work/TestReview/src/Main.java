
# Module 1 Code Reviews

        ## Test Plan

        * [x ] Create a hotel of size 50
        * [hard coded ] Can this be accomplished using the console at startup or is it hard coded?
        * [x ] **Check in** a guest to capsule 1
        * [x] **Check in** a guest to capsule 50
        * [x ] **Check in** a guest to capsule 25
        * [x ] **Check in** another guest to capsule 25
        * [yes ] Does the application prevent the new guest from being checked in?
        * [x ] **View guests** starting at capsule 25
        * [yes ] Does the application display the checked in guest at that position?
        * [yes ] Does the application display `unoccupied` for unoccupied capsules?
        * [x ] **Check out** the guest in capsule 25
        * [x ] **View guests** starting at capsule 25
        * [yes ] Does the application display `unoccupied`?
        * [x ] **Check in** a differently named guest to capsule 25
        * [x ] **View guests** starting at capsule 25
        * [yes ] Does the application display the new guest name at that position?
        * [x ] **View guests** starting at capsule 3
        * [yes ] Does the application display the correct number of capsules?
        * [no ] Does the application display the guest checked into capsule 1?
        * [x ] **View guests** starting at capsule 48
        * [yes ] Does the application display the correct number of capsules?
        * [yes ] Does the application display the guest checked into capsule 50?
        * [x ] **Check out** a guest from capsule 30 (or any empty capsule)
        * [yes ] Does the application inform that there is no one checked into that capsule?