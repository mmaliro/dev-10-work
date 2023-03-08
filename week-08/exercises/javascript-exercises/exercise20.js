// PRINT BUSINESS CARD
// Create a function named `printBusinessCard` that accepts an object.
// The object may contain the following properties:
// jobTitle, firstName, and lastName, pithyPhrase
/* Print a business card in the following format:

  Rue Majors
  Architect
  "It's better to burn out than it is to fade away."

Generically:

  firstName lastName
  jobTitle
  "pithyPhrase"
*/
// If any property is missing, omit it. If a missing property creates an empty line, omit the line.
// Hint: object destructing is useful, but not required, here.

function printBusinessCard({ jobTitle, firstName, lastName, pithyPhrase }) {
  const name = [firstName, lastName].filter(Boolean).join(" ");
  const title = jobTitle || "";
  const phrase = pithyPhrase ? `"${pithyPhrase}"` : "";

  console.log(name);
  if (title) console.log(title);
  if (phrase) console.log(phrase);
}



printBusinessCard({
    jobTitle: "Architect",
    firstName: "Rue",
    lastName: "Majors",
    pithyPhrase: "It's better to burn out than it is to fade away."
});
/* Expected output:

  Rue Majors
  Architect
  "It's better to burn out than it is to fade away."
*/

printBusinessCard({
    firstName: "Mac",
    lastName: "Gorrie"
});
/* Expected output:

  Mac Gorrie
*/

printBusinessCard({
    jobTitle: "Instructor",
    firstName: "Netta",
    pithyPhrase: "Happy to help!"
});
/* Expected output:

  Netta
  Instructor
  "Happy to help!"
*/

printBusinessCard({
    jobTitle: "Mystery Guest",
    pithyPhrase: "Life is an illusion..."
});

/* Expected output:

  Mystery Guest
  "Life is an illusion..."
*/