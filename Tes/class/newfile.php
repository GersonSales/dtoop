<?php
class Account {
	
	private $login;
	private $password;
	
	function __construct($login, $password) {
		$this->login = $login;
		$this->password = $password;
	}
	
	public function getLogin() {
		return $this->login;
	}
	
	public function setLogin($login) {
		$this->login = $login;
	}
	
	public function setPassword($password) {
		$this->login = $password;
	}
	
	public function getPassword() {
		return $this->password;
	}
}

?>