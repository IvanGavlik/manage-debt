# manage-debt

Debt Counseling & Repayment Plan System

## Technology

Clojure

**Libraries** 
* mount 
* http-client 
* reitit 
* HugSQL

More info on project no functional requirements in doc/no_functional_requirements.md

## Description

API to assist clients in managing debt through an automated Debt Counseling & Repayment Plan System. The system should
* Analyze a client’s income, expenses, and outstanding debts
* Generate personalized repayment plans using predefined financial rules
* Automate compliance tracking for legal debt counseling
* Provide a client self-service portal for tracking progress

More info on project functional requirements in doc/functional_requirements.md

## Architecture

The system follows a microservices-based architecture to ensure scalability, maintainability, and performance.
It consists of several loosely coupled services communicating via REST APIs.

* Backend: Clojure-based microservices
* Frontend: ? 
* Database: PostgreSQL
* Deployment: Docker + Kubernetes
* Security: OAuth2 for authentication

### System design 

#### Data model and API 

Three main tables 
* client
* debts
* repayment_plan

API 
* Debt Management
* Repayment Plan
* Client portal

More info on architecture and system design here doc/architecture_and_system_design.md

## TODO
* Docker 
* DB 

## License

Copyright © 2025 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
