var employeeView = function () {

	var configMap = {
		path: '',
		dataUrl: '/getuserbyid'
	};

	var getEmployee = function (id) {
		var ID={Id:id};
		$.ajax({
			url: configMap.path + configMap.dataUrl,
			dataType: 'JSON',
			type: 'POST',
			data: ID,
			success: function (result) {
					console.log(result);//打印服务端返回的数据(调试用)
                    if (result['code']==0) {
                        $('#name').text(result['data'].name);
                        $('#code').text(result['data'].id);
                        $('#age').text(result['data'].password);
                    }else{
                        alert(result['msg'])

                    }
                     ;
                },
			error: function () {
				alert("异常！");
			}
		});
	};

	return {
		init: function (id) {
			getEmployee(id);
		},
		setPath: function (path) {
			configMap.path = path;
		}
	};
}();