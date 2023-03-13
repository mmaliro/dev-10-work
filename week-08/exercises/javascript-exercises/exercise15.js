function printRightAlignedArray(arr) {
    let maxLength = 0;
    for (const item of arr) {
        maxLength = Math.max(maxLength, item.length);
    }

    for (const item of arr) {
        console.log(item.padStart(maxLength, " "));
    }

}

printRightAlignedArray(["one", "two hundred", "fifty"]);
printRightAlignedArray(["yes", "no"]);
printRightAlignedArray(["merciful", "cold", "beyond reproach", "brighter", "sad"]);