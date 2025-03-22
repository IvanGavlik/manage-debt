# Architecture and system design for Manage debt

## Overview

The system follows a microservices-based architecture to ensure scalability, maintainability, and performance. It consists of several loosely coupled services communicating via REST APIs.

* Backend: Clojure-based microservices
* Frontend: ? 
* Database: PostgreSQL
* Deployment: Docker + Kubernetes
* Security: OAuth2 for authentication

## Architecture Diagram

+-------------------------------------------+
|          Client Applications              |
|  - Web Portal (React.js)                  |
|  - Mobile App (Optional Future)           |
+-------------------------------------------+
|                           |
| API Requests              | API Requests
v                           v
+-----------------------+       +---------------------------+
|   API Gateway        |       |  Authentication Service   |
| (Reitit + Middleware)|       | (OAuth2, JWT)            |
+-----------------------+       +---------------------------+
|                            
| REST API Calls                        
v                         
+------------------------------------------------------+
|               Business Services (Clojure)           |
|  - Debt Assessment Service                          |
|  - Repayment Plan Service                          |
|  - Payment Tracking Service                        |
|  - Advisor & Client CRM Service                    |
|  - Notification Service                            |
+------------------------------------------------------+
|                        
v                        
+-----------------------------------+
|        Database Layer             |
| - PostgreSQL (HugSQL)             |
| - Redis (For caching)             |
+-----------------------------------+
|
v
+----------------------------+
| Third-Party Integrations   |
| - Bank APIs (Debt Fetching)|
| - Payment Gateways         |
| - Credit Score Providers   |
+----------------------------+

## Service Breakdown

### API Gateway (Reitit)
* Central entry point for all client and advisor requests.
* Handles authentication, rate limiting, and API versioning.

### Business Services
* Debt Assessment Service
  * Accepts client financial data and calculates DTI (Debt-to-Income Ratio). 
  * Suggests Avalanche or Snowball repayment strategies based on financial profile.

* Repayment Plan Service
  * Generates a custom repayment schedule based on the chosen strategy.
  * Stores debt prioritization logic.

* Payment Tracking Service
  * Logs payments made by users and updates outstanding balances. 
  * Integrates with payment gateways (e.g., Stripe, PayPal).

* Advisor & Client CRM Service 
  * Provides a dashboard for financial advisors to track client progress.
  * Handles appointment scheduling and communication.

* Notification Service
  * Sends email/SMS reminders for missed payments. 
  * Alerts advisors of high-risk clients.

## Data Flow Example (Repayment Plan Generation)
* Client Submits Financial Data → Web app sends data via API Gateway.
* Debt Assessment Service calculates DTI and risk score. 
* Repayment Plan Service selects the best repayment strategy (Avalanche or Snowball).
* Plan is stored in PostgreSQL, and a notification is sent to the client. 
* Client Dashboard Updates to display new plan.


## Scalability & Future Enhancements

* Horizontally Scalable Microservices → Each service can be independently scaled.
* Redis caching for frequent queries.
* GraphQL Support (Future) → Optimized API queries for frontend efficiency.


## API

### Debt Management:

* POST /debt-assessment → Accepts client debt details and stores them.
* GET /debt-assessment/{id} → Retrieves a stored debt assessment. 
* PUT /debt-assessment/{id} → Updates a client’s financial status.


### Automated Repayment Plan:

* Based on debt-to-income ratio, generate a recommended monthly repayment schedule. 
* Prioritize high-interest debts first (Snowball or Avalanche method). 
* Store repayment plans and track monthly payments.


### Compliance & Legal Tracking:

* Automatically generate compliance reports for regulated debt counseling.
* Track missed payments and trigger advisor follow-ups.

### Client Self-Service Portal:

* GET /client/{id}/debt-plan → Clients can view their repayment plan.
* POST /client/{id}/payment → Clients log payments, updating their balance.
* POST /client/{id}/request-advice → Clients can request a session with a debt advisor.

## Data model (PostgreSQL)

CREATE TABLE clients (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
email VARCHAR(255) UNIQUE,
phone VARCHAR(50),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE debts (
id SERIAL PRIMARY KEY,
client_id INT REFERENCES clients(id) ON DELETE CASCADE,
creditor VARCHAR(255),
amount DECIMAL,
interest_rate DECIMAL,
monthly_payment DECIMAL,
status VARCHAR(50) DEFAULT 'active',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE repayment_plans (
id SERIAL PRIMARY KEY,
client_id INT REFERENCES clients(id) ON DELETE CASCADE,
total_debt DECIMAL,
recommended_monthly_payment DECIMAL,
strategy VARCHAR(50), -- Snowball or Avalanche
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
