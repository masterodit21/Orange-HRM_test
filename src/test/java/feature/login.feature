Feature: Login di web HRM

  Scenario: Login dengan username dan password valid
    Given user sedang berada di halaman login
    When memasukan username "admin"
    And memasukan password "admin123"
    And menekan tombol login
    Then user berhasil masuk dahboard

  Scenario: Login dengan username dan password invalid
    Given user sedang berada di halaman login
    When memasukan username "tedy"
    And memasukan password "tedy123"
    And menekan tombol login
    Then user gagal masuk dahboard