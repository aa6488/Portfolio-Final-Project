<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="app-header headerPosition">
		<nav class="navbar navbar-expand-lg">
			<div class="navbar-collapse justify-content-end px-0" id="navbarNav">
				<ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
					<a href="#" target="_blank" id="header-bell" class="headerItem-bell"> 
						<img src="/resources/uploads/member/icon/profile/bell.png" alt="" width="33" height="33">
					</a>
					<a href="#" target="_blank" id="header-chat" class="headerItem-message"> 
						<img src="/resources/uploads/member/icon/profile/message.png" alt="" width="33" height="33">
					</a>
					<li class="nav-item dropdown">
						<a class="nav-link nav-icon-hover headerItem-icon" href="#" id="drop2" data-bs-toggle="dropdown" aria-expanded="false"> 
						<img src="${sessionScope.path}${sessionScope.picture}" alt="" width="35" height="35" class="rounded-circle">
						</a>
						<div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
							<div class="message-body">
								<a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item"> <i class="ti ti-user fs-6"></i>
									<p class="mb-0 fs-3">내 프로필</p>
								</a> <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item"> <i class="ti ti-mail fs-6"></i>
									<p class="mb-0 fs-3">마이페이지</p>
								</a> <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item"> <i class="ti ti-list-check fs-6"></i>
									<p class="mb-0 fs-3">내 프로젝트</p>
								</a> <a href="./authentication-login.html" class="btn btn-outline-primary mx-3 mt-2 d-block shadow-none">Logout</a>
							</div>
						</div></li>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>