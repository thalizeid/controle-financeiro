<!-- RM 99158 - THALITA ZEID MARQUES SILVA-->  


<!DOCTYPE html>
<html lang = "pt-br"></html>
<!-- HEAD: Meta, links e title -->  

<head>    
    <meta charset = "UTF-8">
    <meta name = "viewport" content="widht-device-widht, initial scale=1.0" title="Logo Torre">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap" rel="stylesheet">
    <title>Torre</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <style type="text/css">
 
.my-color{
    color: var(--bs-pink);
    background: rgb(224,100,105);
    background: linear-gradient(0deg, rgba(224,100,105,0.87) 0%, rgba(224,100,105,1) 100%);
}

.c.img{
    float: center;
    
}

.container{
    padding-bottom: 40px;
    width: 50%;    
}

.formulario{
    background: radial-gradient(83.81% 79.85% at 51.85% 53.55%, rgba(225, 198, 188, 0.08) 0%, rgba(242, 182, 160, 0.85) 100%);
    width: 100%;
    padding: 20px;
    color: #FFF;
    font-family: Inter;
    text-align: center;
}

.img-fluid{
    float: center;
}

.btn-criar{
    float: right;
    width: 15%;
    min-width: 130px;
    margin-right: 2%;
    height: 50px;
    background-color:#F2B6A0;
    text-align: center;
    margin-top: 25px;
    color: #FFF;
    font-size: 15px;
    font-family: Inter;
    font-style: normal;
    font-weight: 500;
    line-height: normal;

}

.submit-button{
    float: center;
    width: 100%;
    height: 50px;
    text-align: center;
    margin-top: 25px;
    background-color:#DEDEA7;
    color: #FFF;
    font-family: Inter;
}

</style>

</head>

<!-- BODY -->  

<body class="my-color">


    <header>
   
    </header>

    <div class= "container">

        <div class="row">
            <div class = "col-sm-12 col-md-4"> </div>

            <div class = "col-sm-12 col-md-4">
            <img src = "images/torre.png" alt="Logo Torre" class="img-fluid"></div>
        </div>
    </div>
    
    <div class="container">
        <div class="formulario">
            <div class="col-md-6 offset-md-3">
            
            
             <c:if test="${empty user }">
	    <span class="navbar-text text-danger" style="margin-right:10px" >
	        ${erro }
	  	</span>	
            </c:if>
            
                <h5>FAÇA SEU LOGIN:</h5></div><br>
                
        <form action="login"  method="post"> 
        <div class="form-group">
            <div class="col-md-6 offset-md-3">
                <input type="text" name="email" placeholder=" digite seu email"> <BR>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-6 offset-md-3">
                <input type="password" name="senha" placeholder="digite sua senha">
            </div>
        </div>      
        <div class="col-md-6 offset-md-3">

        <button type="submit" class="submit-button">ENTRAR</button></div>            </div>             
            </div></div></div>
        </div>
    </form> 
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
