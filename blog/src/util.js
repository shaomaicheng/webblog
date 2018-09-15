function getLocalTime(nS) {
    return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/, ' ');
}

function isEmpty(string) {
    return string == null || string == ''
}

export {getLocalTime, isEmpty}
