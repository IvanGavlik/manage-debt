# Functional requirements for Manage debt 

## Into

Automated Debt Counseling & Repayment Plan System tasks have an API to assist 
clients in managing debt through an automated Debt Counseling & Repayment Plan System. 
The system should:

* Analyze a client’s income, expenses, and outstanding debts.
* Generate personalized repayment plans using predefined financial rules.
* Automate compliance tracking for legal debt counseling.
* Provide a client self-service portal for tracking progress.

## Debt Prioritization & Payment Strategy

When designing an automated repayment plan, the system must consider the client's debt-to-income (DTI) ratio and 
apply a repayment strategy that optimizes their ability to clear debts efficiently.

###  Debt-to-Income (DTI) Ratio Calculation

**Formula:**
DTI = (Total Monthly Debt Payments / Total Monthly income) * 100

**Example:**
* Monthly income: $4,000
* Monthly debt payments: $1,500
* DTI = (1500 / 4000) × 100 = 37.5%

A high **DTI (above 40%)** signals financial stress, requiring an aggressive repayment plan.

### Debt Repayment Strategies

Two common approaches for debt repayment are:
* Avalanche Method (Highest Interest First)
* Snowball Method (Smallest Debt First)

### Avalanche Method (Cost-Efficient, Faster Payoff)**
* Prioritizes debts with the highest interest rates first.
* Saves money over time by minimizing total interest paid.
* Best for: Clients with high-interest loans (e.g., credit cards, payday loans).

**Example**
Debt	Amount	Interest Rate	Min Payment
Credit Card A	$3,000	22%	$150
Personal Loan	$5,000	12%	$200
Car Loan	$10,000	5%	$300

**Plan**: Pay the minimum on all debts but allocate extra funds to the highest-interest debt (Credit Card A). Once it's cleared, move to the next highest (Personal Loan).


### Snowball Method (Motivational, Behavior-Based)**
* Focuses on paying off the smallest debt first, regardless of interest rate.
* Builds motivation through quick wins.
* Best for: Clients struggling with financial discipline.

**Example**
Debt	Amount	Interest Rate	Min Payment
Medical Bill	$1,200	0%	$100
Credit Card B	$2,500	18%	$150
Student Loan	$8,000	6%	$300

**Plan**: Pay off the $1,200 Medical Bill first, then move to the $2,500 Credit Card B, and so on.

## Automated Plan Generation
* System retrieves client’s income, total debts, and interest rates.
* Calculates DTI and suggests a repayment approach:
  * If DTI > 40% → Avalanche (cost-saving) is recommended.
  * If DTI < 40% but client has multiple small debts → Snowball is suggested.
* Allocates extra funds to the top-priority debt (based on selected strategy).
* Adjusts monthly payments dynamically as debts are paid off.