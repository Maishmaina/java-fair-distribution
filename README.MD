# JAVA FAIR DISTRIBUTION TEST



## Getting Started

Follow these steps to get started with the project:
- Step 1: Clone the repository
- Step 2: Install dependencies
     FOR VSCODE TEST INSTALL THIS EXTENSTION https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

- Step 3: to test this project using JUNIT VSCODE  instruction is provided in this link https://code.visualstudio.com/docs/java/java-testing


# a brief description of definition of 'fair'
In the context of the code provided, "fair" distribution refers to an allocation of prizes that aims to balance the total value of prizes each winner receives as closely as possible.
Here's how this fairness is implemented:

# Equal Total Value:
The code calculates the total value of prizes each winner receives, ensuring that the difference in total values among winners is minimized.
# Balancing Distribution:
Prizes are distributed in a way that attempts to balance the total value of prizes among winners. This is achieved by assigning each prize to the winner with the least total value of prizes received so far.
# Iterative Allocation:
The algorithm iterates through the shuffled list of prizes, continuously assigning each prize to the winner with the least total value. This process repeats until all prizes are allocated.
# Dynamic Adjustment:
The algorithm dynamically adjusts the distribution by considering the current total value of prizes each winner has received, ensuring that subsequent prizes are allocated to balance the overall distribution.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.