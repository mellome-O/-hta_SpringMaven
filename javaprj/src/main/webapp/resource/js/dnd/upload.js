window.addEventListener("load", function(){
    var section = this.document.querySelector("#upload");
    var dropZone = section.querySelector(".drop-zone");
    var trigerButton = section. querySelector(".trigerButton");
    var file = section.querySelector("input[type=file]");
    var percentSpan = section.querySelector(".percent");
    var progressDiv = dropZone.querySelector(".progress");
    var filelistLi = section.querySelector(".file-list li");
    
    //progress
   
    
    
    //트리거 버튼
    trigerButton.onclick = function(e){
    	alert("aa");
    	
    	var event = new MouseEvent("click",{
    		view: window,
    		bubbles: true,
    		cancelable:true
    	}
    	);
    	file.dispatchEvent(event);
    };
    
    
    //drop zone 에서 사용되는 이벤트
    dropZone.addEventListener("dragenter", function(e){
        e.preventDefault(); //파일 열리지 않도록 기본행위 막기
        console.log("들어왔니?");

        // for(var key in e.dataTransfer) //키를 뽑아낸다
        //     console.log(key);
        for(var key in e.dataTransfer.types)
            console.log(e.dataTransfer.types[0]);
    });
    dropZone.addEventListener("dragleave", function(e){
        e.preventDefault();
        console.log("나갔니?");
        dropZone.classList.remove("invalide");
        dropZone.classList.remove("valide");
    });
    dropZone.addEventListener("dragover", function(e){
        e.preventDefault();
        console.log("위에 있니?");
        if(e.dataTransfer.types[0] == "Files")
        {//alert("드랍하세요");
        dropZone.classList.add("valide");
    }
        else{
            console.log("유효한 파일이 아닙니다.");
            dropZone.classList.add("invalide");
        }
    });
    dropZone.addEventListener("drop", function(e){
        e.preventDefault();
        // dropZone.classList.remove("valide");
        // dropZone.classList.remove("invalide");
        // console.log("드랍?");
        
         var files = e.dataTransfer.files;
        var size = files.length;

         if(size>1){
             alert("파일은 하나씩만 업로드 할 수 있습니다.");
             return;
         }
         var file = files[0];
        // console.log(file.type); //파일종류

        // var regex = new RegExp("image/(jpeg|png|gif)");

        // if(!file.type.match(regex)){
        //     alert("유효한 파일 형식이 아닙니다.");
        //     return;
        // }

         if(file.size>9*1024*1024){
             alert("10메가 이상의 파일은 업로드 할 수 없습니다.");
             return;
         }
        
        //멀티파트 -->FormData
        var formData = new FormData();
        formData.append("file",file);
        
        var request = new XMLHttpRequest();
        request.addEventListener("load", function(e){
        	
        	if(request.responseText == "ok"){
        		//목록을 새로 요청하기 //변수명 밖에꺼랑 안에꺼 충돌안나게 다른이름으로 설정하기
        		var req = new XMLHttpRequest();
        		alert("드렁");
        		req.addEventListener("load", function(e){
        			console.log(req.responseText);
        			console.log(typeof req.responseText);
        
        			var json = JSON.parse(req.responseText);
        			var size = json.length;
        			alert(json.length);
        			filelistLi.innerText = json[0].name;
        		});
        		req.open("GET","/javaprj/file-list");
        		req.send();
        	}
        });
        
        //이벤트를 함수가 바인딩 할 때 사용하는 녀석
        //진척도 %
        request.upload.addEventListener("progress", function(e){
        	//loaded, total
        	//console.log(Math.round(e.loaded * 100 / e.total));
        	
        //if(e.lengthComputable){
        	var degree = Math.round(e.loaded * 100 / e.total);
        	percentSpan.innerText = degree;
        	progressDiv.style.width = degree + "%";
        //}
       // else
       // 	progressBoxDiv.innerText="전송크기를 계산할 수 없습니다.";
        
        
        });
        	
        request.open("POST", "../../../upload");
        request.send(formData); //동기형으로 하면 여기서 멈춤현상
        //비동기는 메인흐름 안잠그고 백그라운드에서 파일업로드 작업 중 다른 것 할 수 있음
        //요청한 것이 응답으로 왔을 때 event로 제공해주고있다
        //비동기로 했을 땐 사용자가 또 반복? 중복해서 행위하지않도록
        //event처리가 필요하다
        //load, error, abort, uploadProgress 4가지 이벤트필요

    });
    /*
    // drop zone 에서 사용되는 이벤트
    dragenter   : 드래그된 리소스가 drop zone에 들어올 때
    dragleave   : drop zone에 있던 드래그가 영역 밖으로 나갈 때
    dragover    : drop zone에서 드래그 상태로 이동중일 때
    drop        : drop zone에서 드랍할 때
    */

});