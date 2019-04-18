$(function () {

    $('#add_btn').click(function () {
        methods.addHandle();
    });

    $('#carsTBody').on('click','.edit', function () {
        trIndex = $('.edit', '#carsTBody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    });

    // $('a.del').click(function () {
    //     $(this).parents('tr').remove();
    // });

    $('#carsTable').on('hide.bs.modal',function() {
        addEnter = true;
        $('#carsTBody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });

});

var addEnter = true,
    noRepeat = true,
    licenseArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {

    addHandle: function (the_index) {
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            methods.checkRepeat();
            if (noRepeat) {
                methods.setStr();
                $('#carsTBody').append('<tr>' + tdStr + '</tr>');
                $('#carsTable').modal('hide');
            }
        }else{
            methods.setStr();
            $('#carsTBody tr').eq(trIndex).empty().append(tdStr);
            $('#carsTable').modal('hide');
        }
    },
    editHandle: function (the_index) {

        var tar = $('#carsTBody tr').eq(the_index);
        var nowConArr = [];
        for (var i=0; i<tar.find('td').length-1;i++) {
            var a = tar.children('td').eq(i).html();
            nowConArr.push(a);
        }

        $('#carsTable').modal('show');

        for (var j=0;j<tarInp.length;j++) {
            tarInp.eq(j).val(nowConArr[j])
        }
        for (var p=0;p<tarSel.length;p++) {
            var the_p = p+tarInp.length;
            tarSel.eq(p).val(nowConArr[the_p]);
        }

    },
    setStr: function () {

        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
        }
        tdStr+= '<td><a href="#" class="edit">编辑</a> <a href="#" class="del">删除</a></td>';

    },

    checkMustMes: function () {

        if ($('#licenseNum').val().trim()==='') {
            bootbox.alert({
                title: "温馨提示",
                message: "车牌号码不能为空",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#brand').val().trim()==='') {
            bootbox.alert({
                title: "温馨提示",
                message: "汽车品牌不能为空",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('#color').val().trim()==='') {
            bootbox.alert({
                title: "温馨提示",
                message: "汽车颜色不能为空",
                closeButton:false
            })
            hasNullMes = true;
            return
        }

    },
    checkRepeat: function () {

        licenseArr = [];

        for (var i = 0; i<$('#carsTBody tr:not(".has_case")').length;i++) {
            var par = '#carsTBody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(1)', par).html().trim();
            licenseArr.push(a);
        }
        var licenseNum = $('#licenseNum').val().trim();

        if (licenseArr.indexOf(licenseNum)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "温馨提示",
                message: "该车牌号码已存在",
                closeButton:false
            })
            return;
        }
        noRepeat = true;
    }
}