/**
 *
 * @author fogsbridge
 * @since
 */
export function isExternalUrl(url) {
  if (!url) {
    return false
  }

  if (url.startsWith('http://') || url.startsWith('https://')) {
    return true
  }

  if (url.startsWith('//')) {
    return true
  }

  return false
}
