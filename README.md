# Job Posting Notifier
A Dockerized Java Spring Boot service running on Google Cloud Platform (GCP) that periodically checks for new job postings from various API sources and sends real-time notifications using [ntfy](https://ntfy.sh/).

Infrastructure is managed with Terraform, and CI/CD is handled using GitHub Actions (GHA).

## Points of interest
- [API clients](src/main/java/com/lvnlx/job/posting/notifier/client)
- [Core notification logic](src/main/java/com/lvnlx/job/posting/notifier/service/JobPostingNotifier.java)
- [GCP infrastructure (Terraform)](/terraform)
- [CI/CD pipeline (GHA)](.github/workflows/deploy.yml)
