variable "image_name" {
  type = string
}

variable "notification_topic" {
  sensitive = true
  type = string
}

variable "project_id" {
  type = string
}

variable "project_name" {
  type = string
}

variable "region" {
  type = string
}