package kz.kaznitu.lessons.boottestarman.models;

import javax.persistence.*;

    @Entity
    public class Department {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String departmentName;
        private String city;


        public Department() {
        }

        public Department(String departmentName, String city) {
            this.departmentName = departmentName;
            this.city = city;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }