// MANAGER FEATURE REQUESTS
// You have three managers: A, B, and C.
// Occasionally, they ask you to add features to your company software.
// Use if/else statements to enforce the following rules:
// - If all three ask for the feature, print "Feature in progress."
// - If any two of the three ask, print "Adding feature to schedule."
// - If only one of the three ask, print "Going to hold off for a bit."
// - If none of the managers ask, print "Nothing to do..."

const managerAAsked = true;
const managerBAsked = false;
const managerCAsked = true;

// 1. Add decisions statements to cover all scenarios.

// Scenario 1: All three managers ask for the feature.
if (managerAAsked && managerBAsked && managerCAsked) {
    console.log("Feature in progress.");
    }
    // Scenario 2: Any two of the three managers ask for the feature.
    else if ((managerAAsked && managerBAsked) || (managerAAsked && managerCAsked) || (managerBAsked && managerCAsked)) {
    console.log("Adding feature to schedule.");
    }
    // Scenario 3: Only one of the three managers asks for the feature.
    else if (managerAAsked || managerBAsked || managerCAsked) {
    console.log("Going to hold off for a bit.");
    }
    // Scenario 4: None of the managers ask for the feature.
    else {
    console.log("Nothing to do...");
    }
    
    
    
    
    
    
    

// 2. Change manager variables to test all scenarios.

