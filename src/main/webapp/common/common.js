//关闭当前弹出层
function closeIframe() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

function showloading(t) {
    if (t) {//如果是true则显示loading
        console.log(t);
        //1。
        loading = layer.load(1, {
            shade: [0.1, '#fff'] //0.1透明度的白色背景
        });
        //1.end
        //2.带文字的
        var loadingIndex = layer.load(2, { //icon支持传入0-2
            shade: [0.5, 'gray'], //0.5透明度的灰色背景
            content: '加载中...',
            success: function (layero) {
                layero.find('.layui-layer-content').css({
                    'padding-top': '39px',
                    'width': '60px'
                });
            }
        });
        //2 end
    }else{//如果是false则关闭loading
        console.log("关闭loading层:" + t);
        layer.closeAll('loading');
    }
}