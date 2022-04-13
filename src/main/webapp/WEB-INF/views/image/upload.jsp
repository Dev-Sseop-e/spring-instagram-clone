<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ include file="../layout/header.jsp" %>

    <!--Center photo upload page-->
        <main class="uploadContainer">
           <!--Photo upload box-->
            <section class="upload">
               
               <!--Photo upload logo-->
                <div class="upload-top">
                    <a href="home.html" class="">
                        <img src="/images/logo.jpg" alt="">
                    </a>
                    <p>Upload photo</p>
                </div>
                <!--Photo upload logo end-->
                
                <!--Photo upload Form-->
                <form class="upload-form" action="/image" method="post" enctype="multipart/form-data" >
                    <input  type="file" name="file"  onchange="imageChoose(this)" />
                    <div class="upload-img">
                        <img src="/images/person.jpeg" alt="" id="imageUploadPreview" />
                    </div>
                    
                    <!--Photo description + upload button-->
                    <div class="upload-form-detail">
                   		 <input type="text" placeholder="Photo description" name="caption" />
                        <button class="cta blue">Upload</button>
                    </div>
                    <!--Photo description end-->
                    
                </form>
                <!--Photo upload Form end-->
            </section>
            <!--Photo upload box end-->
        </main>
        <br/><br/>
	
	<script src="/js/upload.js" ></script>
    <%@ include file="../layout/footer.jsp" %>
