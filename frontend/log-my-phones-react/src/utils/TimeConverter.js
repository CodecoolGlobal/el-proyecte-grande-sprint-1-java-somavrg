// TimeConverter.js

function secondsToTimeString(seconds, showMinuteIfZero) {
    const days = Math.floor(seconds / 86400);
    const hours = Math.floor((seconds % 86400) / 3600);
    const minutes = Math.floor((seconds % 3600) / 60);
    const remainingSeconds = seconds % 60;

    let result = '';

    if (days > 0) {
        result += `${days}d `;
    }

    if (hours > 0 || result !== '') {
        result += `${hours}h `;
    }

    if (showMinuteIfZero) {
        result += `${minutes}m `;
    } else if (hours > 0 || result !== '') {
        result += `${hours}h `;
    }

    if (remainingSeconds > 0 || result === '') {
        result += `${Math.floor(remainingSeconds)}s`;
    }

    return result.trim();
}

export { secondsToTimeString };
