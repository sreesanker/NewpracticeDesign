package com.example.asus.newpracticedesign;

import java.io.Serializable;
import java.util.List;

public class Model implements Serializable {

    /**
     * first_name : sree
     * last_name : babu
     * id_no : 15
     * upi_no : 12
     * birth_certificate_number : 21
     * date_of_birth : date
     * gender : m
     * nationality : ind
     * class : 1
     * subject : maths
     * position : teac
     * mobile_number : 63555
     * contract : 23
     * start_date : date
     * end_date : date
     * add_experience : [{"institution_name":"arr","start_date":"date","end_date":"date","teaching_level":"high","add_sub_taught":[{"subject":"maths"}]}]
     * add_teaching_roles : [{"roles":"teac","add_sub_taught_roles":[{"subject":"phy"}]}]
     * add_other_info : [{"add_info":"abc"}]
     */

    private String first_name;
    private String last_name;
    private int id_no;
    private int upi_no;
    private int birth_certificate_number;
    private String date_of_birth;
    private String gender;
    private String nationality;
    //@com.google.gson.annotations.SerializedName("class")
    private String classX;
    private String subject;
    private String position;
    private int mobile_number;
    private int contract;
    private String start_date;
    private String end_date;
    private List<AddExperienceBean> add_experience;
    private List<AddTeachingRolesBean> add_teaching_roles;
    private List<AddOtherInfoBean> add_other_info;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId_no() {
        return id_no;
    }

    public void setId_no(int id_no) {
        this.id_no = id_no;
    }

    public int getUpi_no() {
        return upi_no;
    }

    public void setUpi_no(int upi_no) {
        this.upi_no = upi_no;
    }

    public int getBirth_certificate_number() {
        return birth_certificate_number;
    }

    public void setBirth_certificate_number(int birth_certificate_number) {
        this.birth_certificate_number = birth_certificate_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<AddExperienceBean> getAdd_experience() {
        return add_experience;
    }

    public void setAdd_experience(List<AddExperienceBean> add_experience) {
        this.add_experience = add_experience;
    }

    public List<AddTeachingRolesBean> getAdd_teaching_roles() {
        return add_teaching_roles;
    }

    public void setAdd_teaching_roles(List<AddTeachingRolesBean> add_teaching_roles) {
        this.add_teaching_roles = add_teaching_roles;
    }

    public List<AddOtherInfoBean> getAdd_other_info() {
        return add_other_info;
    }

    public void setAdd_other_info(List<AddOtherInfoBean> add_other_info) {
        this.add_other_info = add_other_info;
    }

    public static class AddExperienceBean implements Serializable{
        /**
         * institution_name : arr
         * start_date : date
         * end_date : date
         * teaching_level : high
         * add_sub_taught : [{"subject":"maths"}]
         */

        private String institution_name;
        private String start_date;
        private String end_date;
        private String teaching_level;
        private List<AddSubTaughtBean> add_sub_taught;

        public String getInstitution_name() {
            return institution_name;
        }

        public void setInstitution_name(String institution_name) {
            this.institution_name = institution_name;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getTeaching_level() {
            return teaching_level;
        }

        public void setTeaching_level(String teaching_level) {
            this.teaching_level = teaching_level;
        }

        public List<AddSubTaughtBean> getAdd_sub_taught() {
            return add_sub_taught;
        }

        public void setAdd_sub_taught(List<AddSubTaughtBean> add_sub_taught) {
            this.add_sub_taught = add_sub_taught;
        }

        public static class AddSubTaughtBean implements Serializable{
            /**
             * subject : maths
             */

            private String subject;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }
        }
    }

    public static class AddTeachingRolesBean implements Serializable{
        /**
         * roles : teac
         * add_sub_taught_roles : [{"subject":"phy"}]
         */

        private String roles;
        private List<AddSubTaughtRolesBean> add_sub_taught_roles;

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public List<AddSubTaughtRolesBean> getAdd_sub_taught_roles() {
            return add_sub_taught_roles;
        }

        public void setAdd_sub_taught_roles(List<AddSubTaughtRolesBean> add_sub_taught_roles) {
            this.add_sub_taught_roles = add_sub_taught_roles;
        }

        public static class AddSubTaughtRolesBean implements Serializable{
            /**
             * subject : phy
             */

            private String subject;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }
        }
    }

    public static class AddOtherInfoBean implements Serializable{
        /**
         * add_info : abc
         */

        private String add_info;

        public String getAdd_info() {
            return add_info;
        }

        public void setAdd_info(String add_info) {
            this.add_info = add_info;
        }
    }
}
